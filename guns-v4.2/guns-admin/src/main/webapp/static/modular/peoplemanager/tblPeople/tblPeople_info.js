/**
 * 初始化人员管理详情对话框
 */
var TblPeopleInfoDlg = {
    tblPeopleInfoData : {}
};

/**
 * 清除数据
 */
TblPeopleInfoDlg.clearData = function() {
    this.tblPeopleInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TblPeopleInfoDlg.set = function(key, val) {
    this.tblPeopleInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TblPeopleInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TblPeopleInfoDlg.close = function() {
    parent.layer.close(window.parent.TblPeople.layerIndex);
}

/**
 * 收集数据
 */
TblPeopleInfoDlg.collectData = function() {
    this
    .set('id')
    .set('name')
    .set('sex')
    .set('state')
    .set('hobby')
    .set('introduce')
    .set('photo');
}

/**
 * 提交添加
 */
TblPeopleInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tblPeople/add", function(data){
        Feng.success("添加成功!");
        window.parent.TblPeople.table.refresh();
        TblPeopleInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tblPeopleInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TblPeopleInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/tblPeople/update", function(data){
        Feng.success("修改成功!");
        window.parent.TblPeople.table.refresh();
        TblPeopleInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.tblPeopleInfoData);
    ajax.start();
}

$(function() {

});
