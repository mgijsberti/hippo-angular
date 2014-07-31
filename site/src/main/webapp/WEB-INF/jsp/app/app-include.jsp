<%@ include file="/WEB-INF/jspf/htmlTags.jspf" %>

<!--  Validation of request attributes -->
<c:if test="${empty description}">
    <c:set var="description" value="empty" />
</c:if>
<c:if test="${empty url}">
    <c:set var="url" value="empty" />
</c:if>

<div class="app" ng-app="greetingApp">
    <div ng-view></div>
</div>

<script src="/app/greeting/angular/angular.min.js"></script>
<script src="/app/greeting/angular/angular-route.min.js"></script>

<script type="text/javascript">

    description = '${description}';
    console.log('description : ' + description);

    url = '${url}';
    console.log('url : ' + url);

    var hippoModule = angular.module("hippoModule",[]);

    hippoModule.factory("hippoDocument",function() {
        return {
            description: description,
            url: url
        }
    });

</script>

<script src="/app/greeting/js/app.js"></script>
<link rel="stylesheet" href="/app/greeting/css/bootstrap-theme.min.css"/>
<link rel="stylesheet" href="/app/greeting/css/bootswatch.less"/>
<link rel="stylesheet/less" href="/app/greeting/css/variables.less"/>
<link rel="stylesheet/less" href="/app/greeting/css/greeting.css">
<script src="/app/greeting/js/less-1.7.3.min.js"></script>

<link rel="stylesheet" href="/app/greeting/css/test.css">
<script src="/app/greeting/js/test.js"></script>




