package es.iesquevedo.UI;

import es.iesquevedo.UI.EntradaSalida;
import es.iesquevedo.dao.GeneradorDeElementos;
import es.iesquevedo.Servicio.GestionDiccionarioService;

public class Main {

    public static void main(String[] args) {
        //DAO: GENERAR EL FICHERO CON LOS ELEMENTOS NECESARIOS
        GeneradorDeElementos generador = new GeneradorDeElementos();
        //SERVICE: CREAR EL SERVICIO QUE GESTIONA LOS ELEMENTOS, PASÁNDOLE EL DAO PARA QUE LO UTILICE
        GestionDiccionarioService dicService = new GestionDiccionarioService(generador);
        //EL MENU PARA QUE SE PUEDA ELEJIR QUE CHINGADOS HACER EN CADA OPCION
        EntradaSalida ui = new EntradaSalida(dicService);

        //ARRANQUE DEL JUEGO
        ui.menuPrincipal();
    }
}



