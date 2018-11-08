rem 为避免Git Extensions持续占用内存资源导致系统无响应，构建完成后移除node_modules文件夹

rem set NODE_PATH=F:\temp\urule-console-js\node_modules
taskkill /im GitExtensions.exe /f
d:\Junction\junction64.exe node_modules F:\temp\urule-console-js\node_modules
d:\Junction\junction64.exe bower_components F:\temp\urule-console-js\bower_components
call webpack --config webpack.config.min.js
d:\Junction\junction64.exe -d bower_components
d:\Junction\junction64.exe -d node_modules
pause