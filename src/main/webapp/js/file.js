

function fileDownload(filePath, fileName) {

	if( filePath != '' && fileName != '' ){
		var url = '/upload/fileDownload?filePath='+filePath+fileName+'&fileName='+fileName;
		
		window.open(url);

	}
}

function fileDownloadZip(filePath,fileName) {

	if( filePath != '' ){
		var url = '/upload/fileDownloadZip?filePath='+filePath+'&fileName='+fileName;
		
		window.open(url);

	}
}

function fileDownloadExcel(fileType, lecId) {

	if( fileType != '' && lecId != '' ){
		var url = '/upload/fileDownloadExcel?type='+fileType+'&lecId='+lecId;
		
		window.open(url);

	}
}