/**
 * @author GJ
 */
urule.SimpleValue=function(arithmetic,data){
	var TIP="请输入值";
	this.container=$("<span>");
	this.valueContainer=generateContainer();
	this.valueContainer.css({
		color:"rgb(180,95,4)"
	});
	this.editor=$(`<textarea class='form-control' rows='4'></textarea>`);
	var self=this;
	this.container.append(this.valueContainer).append(this.editor);
	this.editor.blur(function(){
		var text=self.editor.prop("value");
		if(text!=""){
		    var trimtext = $.trim(text);
		    //if((trimtext.indexOf('x')>=0 || trimtext.indexOf('y')>=0 || trimtext.indexOf('z')>=0) && trimtext!=='x' && trimtext!=='y' && trimtext!=='z'){
		    if(/((?=[\x21-\x7e]+)[^A-Za-z0-9])/.test(trimtext)){    //这个匹配所有键盘上可见的非字母和数字的符号
                var err = null;
                //var context = {};
                do{
                    try{
                        //with(context){  //SyntaxError: E:/MyCode/urule/urule-console-js/src/editor/common/SimpleValue2.js: 'with' in strict mode (22:20)
                            var jsval = eval(text);
                        //}
                        err = null;
                        console.log('结果：'+jsval);

                        $.post(window._server.replace('/urule', '')+'/rule2/tool/test/js', {gs: text, fh: null}, function(data){
                            if(data.status) {
                                console.log('服务器端执行结果：'+data.data);
                                alert(data.data);
                                console.assert(jsval===data.data);
                            } else {
                                console.log('服务器端执行出错：'+data.info);
                                alert('执行出错：'+data.info);
                            }
                        });
                        //alert(jsval);
                    } catch(e) {
                        err = e;
                        if(e.message.indexOf(' is not defined') > 0){
                            var varname = e.message.split(' is not defined')[0];
                            //var pretext = 'var ' + varname + '=';
                            //pretext += 'prompt("请输入变量'+varname+'的值进行测试","");\n';
                            //text = pretext + text;

                            //context[varname] = prompt("请输入变量"+varname+"的值进行测试","");

                            var pretext = 'var ' + varname + '=';
                            var prompttext = $.trim(prompt("请输入变量"+varname+"的值进行测试",""));
                            if(prompttext=='null' || prompttext=='undefined'
                            ||(prompttext.length>1 && prompttext[0]=="'" && prompttext[prompttext.length-1]=="'")){
                                pretext += prompttext;
                            } else {
                                if(varname[varname.length-1] == '$')
                                    pretext += "'"+prompttext+"'";
                                else
                                    //pretext += 'eval("+\''+prompttext+'\'||\''+prompttext+'\'");\n';
                                    pretext += prompttext!='NaN'&&isNaN(+prompttext)?"'"+prompttext+"'":+prompttext;
                            }
                            text = pretext+';\n' + text;
                            console.log('执行语句：'+text);
                        } else {
                            alert('测试js表达式出错：'+e.message);
                            err = null;
                            //return false;
                        }
                    }
                } while (err)
		    }
			URule.setDomContent(self.valueContainer,self.editor.prop("value")); //改成text就可以看到生成的pretext
		}
		self.editor.hide();
		self.valueContainer.show();
		$(this).trigger("DOMSubtreeModified");
		window._setDirty();
	}).mousedown(function(evt){
		evt.stopPropagation();
	}).keydown(function(evt){
		evt.stopPropagation();
	});
	self.editor.hide();
	this.valueContainer.prop("innerText",TIP);
	this.valueContainer.click(function(){
		self.valueContainer.hide();
		var parent=self.container.parent();
		var maxWidth=360;
		if(parent && parent.parent() && parent.parent().parent()){
			parent=parent.parent().parent();
			var css=parent.prop("class");
			if(css && css=="htMiddle htDimmed current"){
				maxWidth=parent.width()-20;
			}
		}
		self.editor.css({
			width:maxWidth
		});
		self.editor.css({display:'inline'});
		self.editor.focus();
		$(this).trigger("DOMSubtreeModified");
	});
	this.arithmetic=arithmetic;
	this.container.append(arithmetic.getContainer());
	this.initData(data);
};

urule.SimpleValue.prototype.getDisplayContainer=function(){
	var container=$("<span>"+this.editor.prop("value")+"</span>");
	if(this.arithmetic){
		var dis=this.arithmetic.getDisplayContainer();
		if(dis){
			container.append(dis);			
		}
	}
	return container;
};

urule.SimpleValue.prototype.initData=function(data){
	if(!data){
		return;
	}
	var text=data["content"];
	//var disText=text.length>15?(text.substring(0,15)+"..."):text;
	URule.setDomContent(this.valueContainer,text);
	this.editor.prop("value",text);
	if(this.arithmetic){
		this.arithmetic.initData(data["arithmetic"]);
	}
};
urule.SimpleValue.prototype.getValue=function(){
	var value=this.editor.prop("value");
	value=value.replace(new RegExp("&","gm"),"&amp;");
	value=value.replace(new RegExp("<","gm"),"&lt;");
	value=value.replace(new RegExp(">","gm"),"&gt;");
	value=value.replace(new RegExp("'","gm"),"&apos;");
	value=value.replace(new RegExp("\"","gm"),"&quot;");
	value=value.replace(new RegExp("\\n","gm"),"&#x000A;");
	value=value.replace(new RegExp("\\r","gm"),"&#x000D;");
	return value;
};
urule.SimpleValue.prototype.getContainer=function(){
	return this.container;
};