/*! modernizr 3.2.0 (Custom Build) | MIT *
 * http://modernizr.com/download/?-adownload-ambientlight-apng-applicationcache-atobbtoa-audio-backdropfilter-backgroundsize-batteryapi-beacon-bgpositionshorthand-blobconstructor-blobworkers-borderradius-canvas-canvastext-classlist-contains-contenteditable-contextmenu-cookies-cors-cryptography-cssall-csscalc-csscolumns-cssexunit-csshairline-cssinvalid-csspointerevents-csspseudotransitions-cssremunit-cssscrollbar-csstransforms-csstransitions-cssvhunit-cssvminunit-cssvwunit-customevent-customprotocolhandler-dart-datachannel-datalistelem-dataset-datauri-dataview-dataworkers-details-devicemotion_deviceorientation-directory-displaytable-documentfragment-emoji-es5array-es5function-es5object-es5string-es5undefined-es6array-es6number-es6object-es6string-eventlistener-exiforientation-fetch-fileinput-filereader-filesystem-flash-flexboxlegacy-fontface-forcetouch-formvalidation-framed-fullscreen-gamepads-generators-geolocation-getusermedia-hashchange-hiddenscroll-history-htmlimports-ie8compat-indexeddb-inputformenctype-inputformmethod-jpeg2000-jpegxr-json-localizednumber-localstorage-lowbandwidth-matchmedia-mathml-mediaqueries-microdata-mutationobserver-objectfit-performance-picture-placeholder-postmessage-progressbar_meter-quotamanagement-sandbox-scriptdefer-search-sessionstorage-sharedworkers-siblinggeneral-smil-speechrecognition-srcdoc-srcset-strictmode-stylescoped-svg-svgasimg-svgfilters-svgforeignobject-target-template-textareamaxlength-time-todataurljpeg_todataurlpng_todataurlwebp-transferables-typedarrays-unknownelements-urlparser-userdata-videoloop-videopreload-vml-webaudio-webgl-webp-webpalpha-webplossless_webp_lossless-websocketsbinary-webworkers-wrapflow-xhr2-xhrresponsetype-xhrresponsetypearraybuffer-xhrresponsetypedocument-xhrresponsetypejson-setclasses !*/
!function(e,t,n){Modernizr.addTest("hiddenscroll",function(){return testStyles("#modernizr {width:100px;height:100px;overflow:scroll}",function(e){return e.offsetWidth===e.clientWidth})}),Modernizr.addTest("mathml",function(){var e;return testStyles("#modernizr{position:absolute;display:inline-block}",function(t){t.innerHTML+="<math><mfrac><mi>xx</mi><mi>yy</mi></mfrac></math>",e=t.offsetHeight>t.offsetWidth}),e}),testStyles("#modernizr{display: table; direction: ltr}#modernizr div{display: table-cell; padding: 10px}",function(e){var t,n=e.childNodes;t=n[0].offsetLeft<n[1].offsetLeft,Modernizr.addTest("displaytable",t,{aliases:["display-table"]})},2);var r=function(){var e=navigator.userAgent,t=e.match(/applewebkit\/([0-9]+)/gi)&&parseFloat(RegExp.$1),n=e.match(/w(eb)?osbrowser/gi),r=e.match(/windows phone/gi)&&e.match(/iemobile\/([0-9])+/gi)&&parseFloat(RegExp.$1)>=9,i=533>t&&e.match(/android/gi);return n||i||r}();r?Modernizr.addTest("fontface",!1):testStyles('@font-face {font-family:"font";src:url("https://")}',function(e,n){var r=t.getElementById("smodernizr"),i=r.sheet||r.styleSheet,o=i?i.cssRules&&i.cssRules[0]?i.cssRules[0].cssText:i.cssText||"":"",s=/src/i.test(o)&&0===o.indexOf(n.split(" ")[0]);Modernizr.addTest("fontface",s)}),Modernizr.addTest("hairline",function(){return testStyles("#modernizr {border:.5px solid transparent}",function(e){return 1===e.offsetHeight})}),Modernizr.addTest("cssinvalid",function(){return testStyles("#modernizr input{height:0;border:0;padding:0;margin:0;width:10px} #modernizr input:invalid{width:50px}",function(e){var t=createElement("input");return t.required=!0,e.appendChild(t),t.clientWidth>10})}),Modernizr.addTest("siblinggeneral",function(){return testStyles("#modernizr div {width:100px} #modernizr div ~ div {width:200px;display:block}",function(e){return 200==e.lastChild.offsetWidth},2)}),testStyles("#modernizr { height: 50vh; }",function(t){var n=parseInt(e.innerHeight/2,10),r=parseInt((e.getComputedStyle?getComputedStyle(t,null):t.currentStyle).height,10);Modernizr.addTest("cssvhunit",r==n)}),testStyles("#modernizr { width: 50vw; }",function(t){var n=parseInt(e.innerWidth/2,10),r=parseInt((e.getComputedStyle?getComputedStyle(t,null):t.currentStyle).width,10);Modernizr.addTest("cssvwunit",r==n)}),Modernizr.addTest("details",function(){var e,t=createElement("details");return"open"in t?(testStyles("#modernizr details{display:block}",function(n){n.appendChild(t),t.innerHTML="<summary>a</summary>b",e=t.offsetHeight,t.open=!0,e=e!=t.offsetHeight}),e):!1}),Modernizr.addTest("formvalidation",function(){var t=createElement("form");if(!("checkValidity"in t&&"addEventListener"in t))return!1;if("reportValidity"in t)return!0;var n,r=!1;return Modernizr.formvalidationapi=!0,t.addEventListener("submit",function(t){(!e.opera||e.operamini)&&t.preventDefault(),t.stopPropagation()},!1),t.innerHTML='<input name="modTest" required><button></button>',testStyles("#modernizr form{position:absolute;top:-99999em}",function(e){e.appendChild(t),n=t.getElementsByTagName("input")[0],n.addEventListener("invalid",function(e){r=!0,e.preventDefault(),e.stopPropagation()},!1),Modernizr.formvalidationmessage=!!n.validationMessage,t.getElementsByTagName("button")[0].click()}),r}),Modernizr.addTest("csscalc",function(){var e="width:",t="calc(10px);",n=createElement("a");return n.style.cssText=e+prefixes.join(t+e),!!n.style.length}),testStyles("#modernizr{overflow: scroll; width: 40px; height: 40px; }#"+prefixes.join("scrollbar{width:0px} #modernizr::").split("#").slice(1).join("#")+"scrollbar{width:0px}",function(e){Modernizr.addTest("cssscrollbar",40==e.scrollWidth)}),Modernizr.addTest("cssexunit",function(){var e,t=modElem.elem.style;try{t.fontSize="3ex",e=-1!==t.fontSize.indexOf("ex")}catch(n){e=!1}return e}),Modernizr.addTest("mediaqueries",mq("only all")),Modernizr.addTest("xhrresponsetypearraybuffer",i("arraybuffer")),Modernizr.addTest("xhrresponsetypedocument",i("document")),Modernizr.addTest("xhrresponsetypejson",i("json")),Modernizr.addTest("svgforeignobject",function(){return!!t.createElementNS&&/SVGForeignObject/.test(o.call(t.createElementNS("http://www.w3.org/2000/svg","foreignObject")))}),Modernizr.addTest("smil",function(){return!!t.createElementNS&&/SVGAnimate/.test(o.call(t.createElementNS("http://www.w3.org/2000/svg","animate")))});var i=function(e){if("undefined"==typeof XMLHttpRequest)return!1;var t=new XMLHttpRequest;t.open("get","/",!0);try{t.responseType=e}catch(n){return!1}return"response"in t&&t.responseType==e},o={}.toString}(window,document);