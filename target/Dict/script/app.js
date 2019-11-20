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
        word:"apple",
        def:"apple is a fruit",
        syn:["pine","mango","grapes"]
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

show(0);




