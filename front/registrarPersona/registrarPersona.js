let RegistrarPersona = new Vue({
    el: '#RegistrarPersonaVue',
    data: {
        nombre: '',
        apellido: '',
        fechaDeNacimiento: '',
        numeroDocumento: '',
        tipoDocumento: '',
        tipoDocumentoSeleccionado: '',
        longitud: '',
        latitud: '',
        radioHogares: '',
        telefono: '',
        email: '',
        whatsappPref: '',
        smsPref: '',
        emailPref: '',
        tipoAnimalSeleccionado: '',
        sexoAnimalSeleccionado: '',
        tamanioAnimalSeleccionado: '',
        nuevoContacto: {
            nombre: '',
            apellido: '',
            telefono: '',
            email: '',
            whatsappPref: false,
            smsPref: false,
            emailPref: false,
        },
        contactosAniadidos:[],
        tiposDocumento: [],
        tiposAnimal: [],
        sexosAnimal: [],
        tamaniosAnimal: []
    },
    methods:{
        enviarDatos : function ()
        {
            console.log("algo");
            console.log(document.getElementById("nombreA").toString());
        },
        actualizarContactos : function ()
        {
            this.contactosAniadidos.push(this.nuevoContacto);
            console.log(this.contactosAniadidos);
            this.nuevoContacto = {
                nombre: '',
                apellido: '',
                telefono: '',
                email: '',
                whatsappPref: false,
                smsPref: false,
                emailPref: false,
            }
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
