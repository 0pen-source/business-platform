/**
 * Created by wyf on 2015/11/16.
 */
;(function($, window, document){
    $.extend({
       /**登陆*/
       ssoSign:function(path, token) {
           $.ajax({
               url      :   path+"/json/sso.json",
               success  :   function(resp) {
                   if(resp && resp.length>0) {
                       $.each(resp, function(index, data) {
                           $.ajax({
                               url     :   "http://"+data.url+"/sso/sign?token="+token,
                               data    :   {domain:data.url},
                               dataType:   "jsonp",
                               crossDomain:true,
                               success :   function() {

                               }
                           });
                       });
                   }
               }
           });
       },
        /**登出*/
        ssoLogout:function(path) {
            $.ajax({
                url      :   path+"/json/sso.json",
                success  :   function(resp) {
                    if(resp && resp.length>0) {
                        $.each(resp, function(index, data) {
                            $.ajax({
                                url     : "http://"+data.url+"/sso/exit",
                                data    :   {url:data.url},
                                dataType:   "jsonp",
                                success :   function() {

                                }
                            });
                        });
                    }
                }
            });
        }

    });

})(jQuery, window, document);
