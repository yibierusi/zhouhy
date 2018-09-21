(function ($) {
    $.FreeTags = function (e) {
        addtagsbox(e);
        var oa = '#' + e + ' input:first';
        var ta = $(oa);
        ta.bind('keypress', function (event) {
            if (ta.val()) {
                if (event.keyCode == 32) {
                    var val = ta.val();
                    var tags = ta.next('input').val();
                    var tag = tags.split(',');
                    if ($.inArray(val, tag) >= 0) {
                        shwoalert(e, val);
                        return false;
                    }
                    ta.before('<a href="javascript:;"><span>' + val + '</span><em></em></a>');
                    ta.next('input').val(ta.next('input').val() + ',' + val)
                    ta.val('');
                }
            }
        });
        ta.bind('keydown', function (event) {
            if (event.keyCode == 8) {
                var del = '#' + e;
                del = $(del);
                if (ta.val() == '') {
                    var name = del.find('a').last().find('span').text();
                    deltags(e, name);
                    del.find('a').last().remove();
                } else {
                    return true;
                }
            }
            ;
        });
    };
    var shwoalert = function (e, name) {
        var c = '#' + e + ' a';
        var fg = $(c);
        $.each(fg, function (val, item) {
            if (name == $(item).find('span').text()) {
                $(this).animate({borderColor: 'red'}, 'slow');
                $(this).animate({borderColor: '#ccc'}, 'slow');
            }
        });
    }
    var bingbtn = function (e) {
        var d = '#' + e;
        $(d).on('click', 'em', function (event) {
            $(this).parents('a').remove();
            var name = $(this).parents('a').find('span').text();
            deltags(e, name);
        })
    }
    var addtagsbox = function (e) {
        if (e == '') throw'ID涓嶅瓨鍦紒';
        var o = '#' + e;
        var t = $(o);
        var tags = t.find('input').val();
        t.find('input').before('<input class="form-control" placeholder="请输入或选择标签" autofocus="autofocus" />');
        if (tags) {
            tag = tags.split(',');
            var oa = '#' + e + ' input:first';
            var ta = $(oa);
            $.each(tag, function (val, item) {
                ta.before('<a href="javascript:;"><span>' + item + '</span><em></em></a>');
            });
        }
        ;bingbtn(e);
    };
    var deltags = function (e, delname) {
        var o = '#' + e;
        var t = $(o);
        var tags = t.find('input').last('input').val();
        var tag = tags.split(',');
        tag.splice($.inArray(delname, tag), 1);
        t.find('input').last('input').val(tag);
    }
})(jQuery)