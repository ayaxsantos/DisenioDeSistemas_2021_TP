var RegistrarPersonaVue = new Vue({
    el: '#RegistrarPersonaVue',
    data: {
        tiposDocumento: [],
        tipoDocumentoSeleccionado: '',
        otrosContactos:[],
        tiposAnimal: [],
        sexosAnimal: [],
        tamaniosAnimal: [],
        tipoAnimalSeleccionado: '',
        sexoAnimalSeleccionado: '',
        tamanioAnimalSeleccionado: '',
    },
    methods:{
        algo : function ()
        {
            console.log("algo");
            console.log(document.getElementById("nombreA").toString());
        }
    },
    created() {
        fetch('http://localhost:8080/datos/persona/tipoDocumento')
            .then(response => response.json()).then(json => {
            this.tiposDocumento = json;
        })
        fetch('http://localhost:8080/datos/mascota/animal')
            .then(response => response.json()).then(json => {
            this.tiposAnimal = json;
        })
        fetch('http://localhost:8080/datos/mascota/sexo')
            .then(response => response.json()).then(json => {
            this.sexosAnimal = json;
        })
        fetch('http://localhost:8080/datos/mascota/tamanio')
            .then(response => response.json()).then(json => {
            this.tamaniosAnimal = json;
        })
    }
})
