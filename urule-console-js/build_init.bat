rem 将此文件及package.json、bower.json复制到F:\temp\urule-console-js目录，然后执行一次此脚本已下载依赖包
rem call尚需测试

rem 以下命令也可以更新已安装的cnpm
rem npm install -g cnpm --registry=https://registry.npm.taobao.org

rem call npm un babel-cli
rem call npm un babel-core
rem call npm un babel-loader
rem rem call npm un babel-preset-es2015
rem call npm un babel-preset-env
rem call npm un babel-preset-react
call npm i -D @babel/cli
call npm i -D @babel/core
call npm i -D babel-loader
call npm i -D @babel/preset-env
call npm i -D @babel/preset-react
call cnpm i -D @babel/plugin-transform-runtime
call cnpm install --save-dev @babel/plugin-proposal-object-rest-spread
call cnpm install --save @babel/runtime
call cnpm install clean-webpack-plugin@0.1.10
call cnpm install css-loader@0.23.1
call cnpm install expose-loader@0.7.1
call cnpm install file-loader@0.8.5
call cnpm install redux-devtools@3.3.1
call cnpm install redux-devtools-dock-monitor@1.1.1
call cnpm install redux-devtools-log-monitor@1.0.11
call cnpm install style-loader@0.13.1
call cnpm install url-loader@0.5.7
rem call cnpm install webpack@1.13.3
call cnpm install webpack-cleanup-plugin@0.2.0


call cnpm install -g webpack@1.13.3



call cnpm install bootbox@4.4.0
call cnpm install bootstrap@3.3.6
call cnpm install codemirror@5.17.0
call cnpm install css@2.2.1
call cnpm install events@1.1.0
call cnpm install flowdesigner@1.1.55
call cnpm install flux@2.1.1
call cnpm install font-awesome@4.6.1
call cnpm install jquery@3.3.1
call cnpm install object-assign@4.1.0
call cnpm install raphael@2.2.1
call cnpm install react@15.4.1
call cnpm install react-dom@15.4.1
call cnpm install react-redux@4.4.6
call cnpm install react-splitter@0.2.0
call cnpm install redux@3.6.0
call cnpm install redux-logger@2.7.4
call cnpm install redux-thunk@2.1.0



rem call cnpm install -g bower
rem path=%path%;C:\Git\cmd


call bower install bootstrapValidator#0.5.3



rem call webpack --config webpack.config.min.js