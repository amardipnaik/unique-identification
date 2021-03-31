app.config(function($routeProvider, $locationProvider)
{
	/*alert("config called");*/
	$routeProvider.when('/', {
		templateUrl : 'views/myProfile.jsp',
		controller : 'detailsControllers'
	}).when('/viewUser.htm', {
		templateUrl : 'views/viewUser.jsp',
		controller : 'detailsControllers'
	}).when('/myWallet.htm', {
		templateUrl : 'views/myWallet.jsp',
		controller : 'detailsControllers'
	}).when('/addWallet.htm', {
		templateUrl : 'views/addWallet.jsp',
		controller : 'detailsControllers'
	})
	.when('/ebill.htm', {
		templateUrl : 'views/ebill.jsp',
		controller : 'detailsControllers'
	})
	.when('/gasBill.htm', {
		templateUrl : 'views/gasBill.jsp',
		controller : 'detailsControllers'
	})
	.when('/payment.htm', {
		templateUrl : 'views/payment.jsp',
		controller : 'detailsControllers'
	})
	.when('/aboutUser.htm', {
		templateUrl : 'views/aboutUser.jsp',
		controller : 'detailsControllers'
	}).when('/contactDetailsUser.htm', {
		templateUrl : 'views/contactDetailsUser.jsp',
		controller : 'detailsControllers'
	})
	.when('/about.htm', {
		templateUrl : 'views/about.jsp',
		controller : 'detailsControllers'
	})	.when('/myProfile.htm', {
		templateUrl : 'views/myProfile.jsp',
		controller : 'detailsControllers'
	}).when('/shopNow.htm', {
		templateUrl : 'views/shopNow.jsp',
		controller : 'detailsControllers'
	}).when('/notificationUser.htm', {
		templateUrl : 'views/notificationUser.jsp',
		controller : 'detailsControllers'
	}).when('/addCard.htm', {
		templateUrl : 'views/addCard.jsp',
		controller : 'detailsControllers'
	}).when('/wishList.htm', {
		templateUrl : 'views/wishList.jsp',
		controller : 'detailsControllers'
	}).when('/designMe.htm', {
		templateUrl : 'views/designMe2.jsp',
		controller : 'detailsControllers'
	}).when('/orderNow.htm', {
		templateUrl : 'views/orderNow.jsp',
		controller : 'detailsControllers'
	}).when('/orderList.htm', {
		templateUrl : 'views/orderList.jsp',
		controller : 'detailsControllers'
	}).when('/feedback.htm', {
		templateUrl : 'views/feedback.jsp',
		controller : 'detailsControllers'
	})

});

