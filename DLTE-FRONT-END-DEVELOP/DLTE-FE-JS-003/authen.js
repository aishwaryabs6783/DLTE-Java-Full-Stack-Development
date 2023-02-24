function authen(){
    let json=[
        {
            "id":"aish",
            "password":"5678"
            
        },
        {
            "id":"vanu",
            "password":"1234"
            
        }
        
    ]
    let uid=document.forms["login"].id.value;
    let upass=document.forms["login"].pass.value;

json.forEach((item) => {
    if(item.id==uid && item.password==upass){
        window.location.href="http://127.0.0.1:5500/DLTE-FE-JS-003/UCH005.html"
    }
});
}