var dictionary = [

    {
        word:"apple",
        def:"apple is a fruit",
        syn:["pine","mango","grapes"]
    },

    {
        word:"ball",
        def:"ball is a thing",
        syn:["football","tennis ball","basket ball"]
    },


    {
        word:"car",
        def:"car is a machine",
        syn:["sports car","super car","big car"]
    },


    {
        word:"computer",
        def:"comp is a computer",
        syn:["lenovo","dell","grapes"]
    },


    {
        word:"baby",
        def:"new child in a family",
        syn:["cute","little","grapes"]
    },




    {
        word:"bmd",
        def:"new baby in a family",
        syn:["cute","little","grapes"]
    },




    {
        word:"mobile",
        def:"mobile is a phoine",
        syn:["iphone","samsung","grapes"]
    },
    {
        word:"apple",
        def:"apple is a fruit",
        syn:["pine","mango","grapes"]
    },


    {
        word:"apple",
        def:"apple is a fruit",
        syn:["pine","mango","grapes"]
    },


];

init = function(){

    for (var i=0;i<dictionary.length;i++){
        document.getElementById('word_list').innerHTML += "<li onclick = 'show(" + i +  ")' >" +
            dictionary[i].word  + "</li>";

    }

}


init();


show = function(i){

    document.getElementById('word_text').innerHTML = dictionary[i].word;
    document.getElementById('definition').innerHTML = dictionary[i].def;

    var list = "";

    for (var j = 0; j< dictionary[i].syn.length;j++){
        list += "<li>" + dictionary[i].syn[j] + "</li>";
        document.getElementById('synonym').innerHTML = list;
    }

}

show(1);


search = function(){

    query = document.getElementById('search').value;
    console.log(query);

    if (query ==""){
        return;
    }

    found = -1;

    for (var index = 0; index < dictionary.length; index++) {
        if (query == dictionary[index].word){
            found = index;
            break;
        }

        else{
            document.getElementById('word_text').innerHTML = "Word not found";
            document.getElementById('definition').innerHTML = "The word you entered is not in our dictionary";
            document.getElementById('synonym').innerHTML = "No synonyms";

        }

    }



    if (found >=0){
        show(found);

    }


}




