/**
 * Created by Administrator on 2016/12/27.
 */
'use strict'
angular.module('gridModule',[]).controller('gridCtrl',['$scope', '$http',function($scope, $http){
        $scope.grid1 = {
            paginationPageSizes:[25, 50,75],
            paginationPageSize:25,
            columnDefs:[
                {name:'source'},
                {name:'destination'},
                {name:'activeFlowTime'},
                {name:'sumB'},
                {name:'sumP'}
            ]
        };
    $scope.grid2 = {
        paginationPageSizes:[25, 50,75],
        paginationPageSize:25,
        columnDefs:[
            {name:'source'},
                {name:'destination'},
                {name:'activeFlowTime'},
                {name:'sumB'},
                {name:'sumP'}
        ]
    };
    
    $http.get('activeFlow/all').success(function(data){
       $scope.grid1.data = data;
       $scope.grid2.data = data;
        //$scope.grid3.data = data;
    });
    var myChart = echarts.init(document.getElementById('mainChart'));
    myChart.setOption ({
        tooltip : {
            trigger: 'axis'
        },
        toolbox: {
            show : true
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'蒸发量',
                type:'bar',
                data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
            }
        ]
    });
}]);