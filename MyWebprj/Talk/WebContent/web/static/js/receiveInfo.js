$(document).ready(function receive() {
/*    let text = document.querySelector('#textarea').value;
    if (!text) {
        alert('请输入内容');
        return;
    }*/
    let item = document.createElement('div');
    item.className = 'item item-left';
    item.innerHTML = `<div class="avatar"><img src="" /></div><div class="bubble bubble-left"><p></p></div>`;
    document.querySelector('.content').appendChild(item);
    document.querySelector('#textarea').value = '';
    document.querySelector('#textarea').focus();
    //滚动条置底
    let height = document.querySelector('.content').scrollHeight;
    document.querySelector(".content").scrollTop = height;
	}
);