package inmobiliaria;

import javax.swing.JOptionPane;

public class Inmobiliaria {
int numCasas = 0;
Casa casas[] = new Casa[5];


public void registrarCasa(){
    Casa home = new Casa();
    home.registrar();
    casas[numCasas] = home;
    numCasas++;
    System.out.println(casas[numCasas-1]);
}

public void eliminarCasa(){

    for (int i = solicitarCasa(); i < numCasas; i++) {
        if (i<casas.length) {
            Casa tmp = casas[i+1];
            casas[i] = tmp;
        }
    }
    numCasas--;
}

public int solicitarCasa(){
    int casa = Integer.parseInt(JOptionPane.showInputDialog("Introduce casa entre 0 y "+(numCasas-1)));
    if ((casa >= 0)&&(casa<=(this.numCasas-1))) {
        return casa;
    } else {
        JOptionPane.showMessageDialog(null, "Casa fuera de rango.");
        solicitarCasa();
        return 0;
    }
}

public boolean validarExistencia(){
    return (numCasas<0);
}

public void verCasa(){
    casas[solicitarCasa()].verDatos();
}

public void rentarCasa(){
    casas[solicitarCasa()].rentar();
}

public void desocuparCasa(){
    casas[solicitarCasa()].desocupar();
}

public void actualizarPrecio(){
    casas[solicitarCasa()].actualizarPrecio();
}

public void verCasas(){
    int cont = 0;
    for (int i = 0; i < this.numCasas; i++) {
        if (!casas[i].getEstado()) {
            casas[i].verDatos();
            cont++;
        }
    }
    if (cont==0) {
        JOptionPane.showMessageDialog(null, "No hay ninguna casa disponible.");
    }
}


public static void main(String[] args) {
        Inmobiliaria inm = new Inmobiliaria();
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog( null,"Seleccione una opción",
            "Inmobiliaria...",JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,new Object[] { 
                "Registrar.",
                "Eliminar c",
                "Rentar.",
                "Desocupar.",
                "Ver casa",
                "Modificar precio",
                "Ver casas.",
                "Salir.",
                 },null);
            switch (opcion){
                case 0:
                    inm.registrarCasa();
                    break;
                case 1:
                    inm.eliminarCasa();
                    break;
                case 2:
                    inm.rentarCasa();
                    break;
                case 3:
                    inm.desocuparCasa();
                    break;
                case 4:
                    inm.verCasa();
                    break;
                case 5:
                    inm.actualizarPrecio();
                    break;
                case 6:
                    inm.verCasas();
                    break;
             
            }
        } while (opcion != 7);
        
    }
    
}
