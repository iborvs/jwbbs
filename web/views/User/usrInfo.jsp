<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .cropper-crop-box, .cropper-view-box {
        border-radius: 50%;
    }
    .cropper-view-box {
        box-shadow: 0 0 0 1px #39f;
        outline: 0;
    }
    #avatarPreview{
        border-radius:50%;
        width: 200px;
        height: 200px;
    }
</style>

<form action="${pageContext.request.contextPath}/action/uploadAvatar" method="POST" enctype="multipart/form-data">
    <div class="row">
        <div class="mx-auto">
            <div id="preview"><img id="avatarPreview" class="avatar" src="../../public/avatar/iborvs.png"/></div>
            <div style="display: none">
                <input type="file" id="avatarUpload" name="avatarPic" onchange="preview(this)"/>
            </div>
        </div>
    </div>
    <input id="avatarUploadCpWidth" type="hidden" name="crop_width">
    <input id="avatarUploadCpHeight" type="hidden" name="crop_height">
    <input id="avatarUploadCpX" type="hidden" name="crop_x">
    <input id="avatarUploadCpY" type="hidden" name="crop_y">
    <div class="row">
        <div class="mx-auto">
            <label for="avatarUpload" class="btn btn-info">更改头像</label>
            <input class="btn btn-success" type="submit" name="submit" value="上传头像">
        </div>
    </div>
</form>
<script>
    var formData = new FormData();
    function upload(){
        formData.append('file', $('#file')[0].files[0]);
        $.ajax({
            url: '${pageContext.request.contextPath}/action/uploadAvatar',
            type: 'POST',
            cache: false,
            data: formData,
            processData: false,
            contentType: false
        }).done(function(res) {
        }).fail(function(res) {});
    }
</script>