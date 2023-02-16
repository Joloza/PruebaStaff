import React from 'react';
import { getCrearLista,getConsultarLista,getDescripcionByName,getBorrarLista } from "./../services/listaReproduccionApi";

const Home = () => {

    const setPlayList = async () => {
        const lista = {
            "nombre": "Lista 2",
            "descripcion": "Lista de canciones de Spotify ",
            "canciones": [
                {
                "titulo": "a",
                "artista": "a",
                "album": "a",
                "anno": "a",
                "genero": "a"
                },
                {
                "titulo": "ab",
                "artista": "ab",
                "album": "ab",
                "anno": "ab",
                "genero": "ab"
                }
            ]
        };
        try {
            const response = await getCrearLista(lista);
            alert("CREADA");
            console.log('Lista creada con éxito:', response.data);
        } catch (error) {
            alert("ERROR");
            console.error('Error al crear la lista:', error);
        }
    };

    const getAllPlayList = async () => {
        
        try {
            const response = await getConsultarLista();
            alert("CONSULTADA");
            console.log('Lista consultada con éxito:', response.data);
        } catch (error) {
            alert("ERROR");
            console.error('Error al consultar la lista:', error);
        }
    };

    const getDescriptionByName = async () => {

        const nombre="Lista 2"
        
        try {
            const response = await getDescripcionByName(nombre);
            alert("CONSULTADA");
            console.log('Lista consultada con éxito:', response.data[0].descripcion);
        } catch (error) {
            alert("ERROR");
            console.error('Error al consultar la lista:', error);
        }
    };

    const deletePlayListByName = async () => {

        const nombre="Lista 1"
        
        try {
            const response = await getBorrarLista(nombre);
            alert("CONSULTADA");
            console.log('Lista consultada con éxito:', response.data);
        } catch (error) {
            alert("ERROR");
            console.error('Error al consultar la lista:', error);
        }
    };

    return (
        <div>
            <button onClick={setPlayList}>setPlayList</button>
            <button onClick={getAllPlayList}>getAllPlayList</button>
            <button onClick={getDescriptionByName}>getDescriptionByName</button>
            <button onClick={deletePlayListByName}>deletePlayListByName</button>
        </div>
        
    );
};

export default Home;