const wrap = window.document.createElement('div');
wrap.innerHTML = `
<div id="zdyxftb" style="position:fixed;right:0px;bottom:100px;background:#fff;opacity:0.5;border:1px solid #dadada;padding:5px;border-radius:10px 0 0 10px;z-index:9999;box-shadow:-1px 1px 3px #000;">
    <button id="chatButton" style="padding: 5px 10px; background: #1C64F2; color: white; border: none; border-radius: 5px; cursor: pointer;">打开聊天</button>
</div>
`;

// 创建iframe容器
const iframeContainer = document.createElement('div');
iframeContainer.id = 'chatIframeContainer';
iframeContainer.style.cssText = 'display:none;position:fixed;right:20px;bottom:160px;width:24rem;height:40rem;z-index:9999;';

// 创建iframe
const iframe = document.createElement('iframe');
iframe.src = 'http://103.181.234.62:2535/chatbot/uGMOkuWvWFFwuQ4l';
iframe.style.cssText = 'width:100%;height:100%;border:none;border-radius:10px;box-shadow:-2px 2px 10px rgba(0,0,0,0.2);';
iframe.allow = 'microphone';

iframeContainer.appendChild(iframe);
window.document.body.appendChild(wrap);
window.document.body.appendChild(iframeContainer);

// 添加按钮点击事件
document.getElementById('chatButton').addEventListener('click', function() {
    const container = document.getElementById('chatIframeContainer');
    if (container.style.display === 'none') {
        container.style.display = 'block';
        this.textContent = '关闭聊天';
    } else {
        container.style.display = 'none';
        this.textContent = '打开聊天';
    }
});