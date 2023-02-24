function calc(){
    let fsal = document.forms['tax'].salary.value;

    if(fsal<300000){
        document.getElementById("rate").setAttribute("value","Nil")
        document.getElementById("total").setAttribute("value","Nil")

    }
    else if(fsal>=300000 && fsal<600000){
        document.getElementById("rate").setAttribute("value","5%")
        document.getElementById("total").setAttribute("value",fsal*0.05)

    }
    else if(fsal>=600000 && fsal<900000){
        document.getElementById("rate").setAttribute("value","10%")
        document.getElementById("total").setAttribute("value",fsal*0.10)
    }
    else if(fsal>=900000 && fsal<1200000){
        document.getElementById("rate").setAttribute("value","15%")
        document.getElementById("total").setAttribute("value",fsal*0.15)
    }
    else if(fsal>=1200000 && fsal<1500000){
        document.getElementById("rate").setAttribute("value","20%")
        document.getElementById("total").setAttribute("value",fsal*0.20)
    }
    else if(fsal>=1500000){
        document.getElementById("rate").setAttribute("value","30%")
        document.getElementById("total").setAttribute("value",fsal*0.30)
    }
}

