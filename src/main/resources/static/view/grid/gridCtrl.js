/**
 * Created by Administrator on 2016/12/27.
 */
'use strict'
angular.module('gridModule',[]).controller('gridCtrl',['$scope', '$http',function($scope, $http){
     var timeFlag="today"; 
     $scope.linkToday ="link_on";
 	$scope.linkWeek ="";
	$scope.grid1 = {
            paginationPageSizes:[25, 50,75],
            paginationPageSize:25,
            columnDefs:[
                {name:'source'},
                {name:'destination'},
                //{name:'rollingTime',displayName:'收集时间',type: 'date', cellFilter: 'date:"yyyy-MM-dd"'},
                {name:'sumB', displayName:'流量字节数'},
                {name:'sumP', displayName:'流量包数'}
            ]
        };
    
        
    $scope.getToday = function(){
    	timeFlag = "today";
    	$scope.linkToday ="link_on";
    	$scope.linkWeek ="";
    	getGridData();
    }
    
    $scope.getWeek = function(){
    	timeFlag = "week";
    	$scope.linkWeek ="link_on";
    	$scope.linkToday ="";
    	getGridData();
    }
    
    function getGridData (){
    	$http.get('activeFlow/all/'+timeFlag).success(function(data){
    	       $scope.grid1.data = data;
    	    });
    	
    }
    
    var myChart = echarts.init(document.getElementById('mainChart'));

    function getMapData(){
    	$http.get("traffic/map").success(function(data){
    	myChart.setOption ({
            tooltip: {
                trigger: 'axis'
            },
            title: {
                left: 'center',
                text: '大数据量面积图',
            },
            toolbox: {
                feature: {
                    dataZoom: {
                        yAxisIndex: 'none'
                    },
                    restore: {},
                    saveAsImage: {}
                }
            },
            legend:{
            	data:['in','out'],
            	x:'left'
            },
            xAxis: [
					{
					    type: 'category',
					    boundaryGap: false,
					    data: data.timeList.map(function (str) {
			                return str.replace('17/', '')
			            }),
					    axisLine: {onZero: true},
			            position:'top'
					},
					{
						gridIndex: 1,
			            type : 'category',
			            boundaryGap : true,
			            axisLine: {onZero: true},
			            data: data.timeList.map(function (str) {
			                return str.replace('17/', '')
			            })
					}
                   ],
            yAxis: [
					{
					    name : '输入流量',
					    type : 'value'
					},
					{
					    gridIndex: 1,
					    name : '输出流量',
					    type : 'value',
					    inverse: true
					}
                   ],
            dataZoom: [{
                type: 'inside',
                start: 0,
                end: 40
            }, {
                start: 0,
                end: 40,
                handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
                handleSize: '80%',
                handleStyle: {
                    color: '#fff',
                    shadowBlur: 3,
                    shadowColor: 'rgba(0, 0, 0, 0.6)',
                    shadowOffsetX: 2,
                    shadowOffsetY: 2
                }
            }],
            grid: [{
                left: 50,
                right: 50,
                height: '35%',
                show:true
            }, {
                left: 50,
                right: 50,
                top: '45%',
                height: '35%',
                show:true
            }],
            series: [
                {
                    name:'输入流量',
                    type:'line',
                    symbolSize: 8,
                    hoverAnimation: false,
                    itemStyle: {
                        normal: {
                            color: '#336699'
                        }
                    },
                    areaStyle: {
                        normal: {
                        }
                    },
                    data: data.trafficInList
                },
                {
                    name:'输出流量',
                    type:'line',
                    symbolSize: 8,
                    hoverAnimation: false,
                    xAxisIndex: 1,
                    yAxisIndex: 1,
                    itemStyle: {
                        normal: {
                            color: '#336699'
                        }
                    },
                    areaStyle: {
                        normal: {
                        	
                        }
                    },
                    data: data.trafficOutList
                },
            ]
        });
    });
    }
    var refresh = function(){
    	getGridData();
    	getMapData();
    }
  //每隔60秒刷新
    setInterval(function(){
        $scope.$apply(refresh);
    },60000);
    refresh();
}]);