const urlDatatable = window.location.pathname.concat('datatable')

// Buat array berisi semua uri
const uriList = [
    "/bill-payment/legacy-biller",
    "/bill-payment/ubp-biller",
    "/business/gl-and-fee",
    "/logging/transaction-log",
    "/logging/settlement-log",
    "/mapping/card-ffid",
    "/mapping/response-code",
    "/mapping/response-message",
    "/pending-task",
    "/system-setting/master-data/branch",
    "/transaction-track",
    "/user-role/user",
    "/user-role/role"
];
  
// Cek apakah urlDatatable mengandung salah satu uri
const foundUri = uriList.find(uri => urlDatatable.includes(uri));

var tableColumns = [];

switch (foundUri) {
    case "/bill-payment/legacy-biller":
        tableColumns = [
            {"data": "id"},
            {"data": "billerCode"},
            {"data": "billerName"},
            {"data": "billerAcctNo"},
            {"data": "chargeAcctNo"},
            {"data": "chargeBiller"},
            {"data": "action","class":"text-center"}
        ];
        break;
    case "/bill-payment/ubp-biller":
        tableColumns = [
            {"data": "id"},
            {"data": "companyCode", "class":"text-center"},
            {"data": "languageCode", "class":"text-center"},
            {"data": "companyName"},
            {"data": "shortName"},
            {"data": "groupTask", "class":"text-center"},
            {"data": "flag", "class":"text-center"}
        ];
        break;
    case "/business/gl-and-fee":
        tableColumns = [
            { "data": "id" },
            { "data": "swname" },
            { "data": "destinationId" },
            { "data": "glAccount1" },
            { "data": "glAccount2" },
            { "data": "glAccount3" },
            { "data": "description" }
        ];
        break;
    case "/logging/transaction-log":
        tableColumns = [
            {"data": "id"},
            {"data": "rrn"},
            {"data": "cardNumber"},
            {"data": "tid"},
            {"data": "proCode"},
            {"data": "createdDate"},
            {"data": "status", "class":"text-center"},
            {"data": "message"},
            {"data":"action","class":"text-center"}
        ];
        break;
    case "/logging/settlement-log":
        tableColumns = [
            {"data": "id"},
            {"data": "xReffNumber"},
            {"data": "xTimestamp"},
            {"data": "settlementDate"},
            {"data": "createdDate"}
        ];
        break;
    case "/mapping/card-ffid":
        tableColumns = [
            {"data": "ID"},
            {"data": "CARD_PREFIX"},
            {"data": "CARD_ISSUER"},
            {"data": "LAST_MODIFIED_BY"},
            {"data": "LAST_MODIFIED_DATE"},
            {"class":"text-center"}
        ];
        break;
    case "/mapping/response-code":
        tableColumns = [
            {"data": "ID"},
            {"data": "SWNAME"},
            {"data": "PROCODE"},
            {"data": "RC_BEFORE"},
            {"data": "RC_AFTER"},
            {"data": "LAST_MODIFIED_BY"},
            {"data": "LAST_MODIFIED_DATE"},
            {"class":"text-center"}
        ];
        break;
    case "/mapping/response-message":
        tableColumns = [
            {"data": "ID"},
            {"data": "RC"},
            {"data": "MESSAGE"},
            {"data": "LAST_MODIFIED_BY"},
            {"data": "LAST_MODIFIED_DATE"},
            {"class":"text-center"}
        ];
        break;
    case "/pending-task":
        tableColumns = [
            {"data": "ID"},
            {"data": "MODULE_NAME"},
            {"data": "SUBJECT"},
            {"data": "OPR_TYPE","class":"text-center"},
            {"data": "CREATED_BY"},
            {"data": "CREATED_DATE"},
            {"data": "STATUS","class":"text-center"},
            {"class":"text-center"}
        ];
        break;
    case "/system-setting/master-data/branch":
        tableColumns = [
            {"data": "ID"},
            {"data": "BRANCH_CODE"},
            {"data": "BRANCH_NAME"},
            {"data": "BRANCH_TYPE","class":"text-center"},
            {"data": "COUNTRY"},
            {"data": "PROVINCE","class":"text-center"},
            {"data": "CITY"},
            {"data": "REGIONAL"},
            {"class":"text-center"}
        ];
        break;
    case "/transaction-track":
        tableColumns = [
            {"data": "ID"},
            {"data": "STEP_TYPE","class":"text-center"},
            {"data": "RESERVED1"},
            {"data": "RESERVED2"},
            {"data": "CREATED_DATE"},
            {"data": "STATUS","class":"text-center"},
            {"data": "DESCRIPTION"},
            {"class":"text-center"}
        ];
        break;
    case "/user-role/user":
        tableColumns = [
            {"data": "ID"},
            {"data": "USERNAME"},
            {"data": "FULL_NAME"},
            {"data": "ENABLED", "class":"text-center"},
            {"data": "IS_LOGIN_WEB", "class":"text-center"},
            {"data": "CREATED_DATE"},
            {"data": "LAST_LOGIN_WEB"},
            {"class":"text-center"}
        ];
        break;
    case "/user-role/role":
        tableColumns = [
            {"data": "ID"},
            {"data": "NAME"},
            {"data": "CREATED_DATE"},
            {"class":"text-center"}
        ];
        break;
    default:
        break;
}