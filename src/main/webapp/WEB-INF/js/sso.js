/**
 * Created by wyf on 2015/11/16.
 */
;(function($, window, document){
    $.extend({
       /**登陆*/
       ssoSign:function(path, token, callbakHandler) {

           function request(data, token, waitAjax) {
               $.ajax({
                   url: "http://" + data.url + "/sso/sign?token=" + token,
                   dataType: "jsonp",
                   crossDomain: true,
                   complete: function (XHR, TS) {
                       waitAjax.finishCouter++;
                   }
               });
           }
           $.ajax({
               url: path + "/sso.json",
               dataType:'json',
               success: function (resp) {
                   if (resp && resp.length > 0) {
                       var counter = resp.length;
                       var waitAjax = {
                           counter: counter,
                           finishCouter: 0,
                           callback: callbakHandler,
                           interval: 0,
                           finish: function () {
                               if (waitAjax.counter == waitAjax.finishCouter) {
                                   clearInterval(waitAjax.interval);
                                   if(waitAjax.callback) {
                                       waitAjax.callback();
                                   }
                               }
                           }
                       };
                       token = token.replace(/\+/g, '%2b');

                       $.each(resp, function(i, data) {
                           request(data, token, waitAjax);
                       });

                       waitAjax.interval = setInterval(waitAjax.finish, 50);
                   }
               }
           });
           //$.ajax({
           //    url      :   path+"/json/sso.json",
           //    success  :   function(resp) {
           //        if(resp && resp.length > 0) {
           //            $.each(resp, function(index, data) {
           //                $.ajax({
           //                    url: "http://" + data.url + "/sso/sign?token=" + token,
           //                    dataType: "jsonp",
           //                    crossDomain: true,
           //                    success: function (resp) {
           //                    }
           //                });
           //
           //            });
           //        }
           //    }
           //});

       },
        /**登出*/
        ssoLogout:function(path, callbakHandler) {
            function request(data, waitAjax) {
                $.ajax({
                    url: "http://" + data.url + "/sso/exit",
                    dataType: "jsonp",
                    //是否跨域
                    //是否异步请求async：false，
                    crossDomain: true,
                    //不管请求是否成功，请求完成就执行函数 success是请求成功才执行函数
                    complete: function (XHR, TS) {
                        waitAjax.finishCouter++;
                    }
                });
            }
            $.ajax({
                url      :   path+"/js/sso.json",
                dataType:'json',
                success  :   function(resp) {
                    if(resp && resp.length>0) {
                        var counter = resp.length;
                        var waitAjax = {
                            counter: counter,
                            finishCouter: 0,
                            callback: callbakHandler,
                            interval: 0,
                            finish: function () {
                                if (waitAjax.counter == waitAjax.finishCouter) {
                                    clearInterval(waitAjax.interval);
                                    if(waitAjax.callback) {
                                        waitAjax.callback();
                                    }
                                }
                            }
                        };
                        $.each(resp, function(i, data) {
                            request(data, waitAjax);
                        });
                        if(callbakHandler) {
                            waitAjax.interval = setInterval(waitAjax.finish, 50);
                        }
                    }
                }
            });
        }

    });

})(jQuery, window, document);
