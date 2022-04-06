/**
 * 人员管理管理初始化
 */
var TblPeople = {
    id: "TblPeopleTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TblPeople.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '序号', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '姓名', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '性别', field: 'sexName', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'state', visible: true, align: 'center', valign: 'middle'},
            {title: '爱好', field: 'hobby', visible: true, align: 'center', valign: 'middle'},
            {title: '介绍', field: 'introduce', visible: true, align: 'center', valign: 'middle'},
            {title: '相片', field: 'photo', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TblPeople.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TblPeople.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加人员管理
 */
TblPeople.openAddTblPeople = function () {
    var index = layer.open({
        type: 2,
        title: '添加人员管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/tblPeople/tblPeople_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看人员管理详情
 */
TblPeople.openTblPeopleDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '人员管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/tblPeople/tblPeople_update/' + TblPeople.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除人员管理
 */
TblPeople.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/tblPeople/delete", function (data) {
            Feng.success("删除成功!");
            TblPeople.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("tblPeopleId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询人员管理列表
 */
TblPeople.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TblPeople.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TblPeople.initColumn();
    var table = new BSTable(TblPeople.id, "/tblPeople/list", defaultColunms);
    table.setPaginationType("client");
    TblPeople.table = table.init();
});
