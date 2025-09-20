package run;

import modelos.*;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Sistema s = new Sistema();
        Scanner sc = new Scanner(System.in);
        int op;


        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Crear Categoria");
            System.out.println("2. Crear Juego");
            System.out.println("3. Crear Jugador");
            System.out.println("4. Crear Equipo");
            System.out.println("5. Crear Arbitro");
            System.out.println("6. Crear Torneo");
            System.out.println("7. Crear Partida en Torneo");
            System.out.println("8. Eliminar Jugador");
            System.out.println("9. Eliminar Equipo");
            System.out.println("10. Eliminar Torneo");
            System.out.println("11. Mostrar estado");
            System.out.println("0. Salir");
            System.out.print("\n> ");
            op = sc.nextInt(); sc.nextLine();


            if(op==1){
                System.out.print("Nombre categoria: ");
                s.categorias.add(new Categoria(sc.nextLine()));
            } else if(op==2){
                System.out.print("Nombre juego: "); String n=sc.nextLine();
                System.out.println("Categorias disponibles: "+s.categorias);
                System.out.print("ID categoria: "); long id=sc.nextLong(); sc.nextLine();
                Categoria cat=null; for(Categoria c:s.categorias) if(c.getId()==id) cat=c;
                if(cat!=null) s.juegos.add(new Juego(n,cat));
            } else if(op==3){
                System.out.print("Nombre: "); String n=sc.nextLine();
                System.out.print("Alias: "); String a=sc.nextLine();
                System.out.print("Ranking: "); int r=sc.nextInt(); sc.nextLine();
                s.jugadores.add(new Jugador(n,a,r));
            } else if(op==4){
                System.out.print("Nombre equipo: "); String n=sc.nextLine();
                Equipo e=new Equipo(n);
                s.equipos.add(e);
                System.out.println("Jugadores disponibles: "+s.jugadores);
                System.out.print("Agregar jugador ID (0 para terminar): ");
                long id=sc.nextLong(); sc.nextLine();
                while(id!=0){
                    for(Jugador j:s.jugadores) if(j.getId()==id) e.addJugador(j);
                    System.out.print("Agregar otro jugador ID (0 fin): ");
                    id=sc.nextLong(); sc.nextLine();
                }
            } else if(op==5){
                System.out.print("Nombre arbitro: ");
                s.arbitros.add(new Arbitro(sc.nextLine()));
            } else if(op==6){
                System.out.print("Nombre torneo: ");
                Torneo t=new Torneo(sc.nextLine());
                s.torneos.add(t);
                System.out.println("Equipos disponibles: "+s.equipos);
                System.out.print("Agregar equipo ID (0 fin): ");
                long id=sc.nextLong(); sc.nextLine();
                while(id!=0){
                    for(Equipo e:s.equipos) if(e.getId()==id) t.addEquipo(e);
                    System.out.print("Agregar otro equipo ID (0 fin): ");
                    id=sc.nextLong(); sc.nextLine();
                }
            } else if(op==7){
                System.out.println("Torneos: "+s.torneos);
                System.out.print("ID torneo: "); long idt=sc.nextLong(); sc.nextLine();
                Torneo t=null; for(Torneo x:s.torneos) if(x.getId()==idt) t=x;
                if(t!=null){
                    System.out.println("Equipos: "+t.getEquipos());
                    System.out.print("ID equipo A: "); long ida=sc.nextLong(); sc.nextLine();
                    System.out.print("ID equipo B: "); long idb=sc.nextLong(); sc.nextLine();
                    Equipo ea=null,eb=null; for(Equipo e:t.getEquipos()){ if(e.getId()==ida) ea=e; if(e.getId()==idb) eb=e; }
                    System.out.println("Juegos: "+s.juegos);
                    System.out.print("ID juego: "); long idj=sc.nextLong(); sc.nextLine();
                    Juego j=null; for(Juego jj:s.juegos) if(jj.getId()==idj) j=jj;
                    System.out.println("Arbitros: "+s.arbitros);
                    System.out.print("ID arbitro: "); long ida2=sc.nextLong(); sc.nextLine();
                    Arbitro ar=null; for(Arbitro a:s.arbitros) if(a.getId()==ida2) ar=a;
                    if(ea!=null && eb!=null && j!=null && ar!=null) t.crearPartida(ea,eb,j,ar);
                }
            } else if(op==8){
                System.out.println("Jugadores: "+s.jugadores);
                System.out.print("ID a eliminar: "); long id=sc.nextLong(); sc.nextLine();
                Jugador borrar=null; for(Jugador j:s.jugadores) if(j.getId()==id) borrar=j;
                if(borrar!=null){ s.jugadores.remove(borrar); for(Equipo e:s.equipos) e.removeJugador(borrar); }
            } else if(op==9){
                System.out.println("Equipos: "+s.equipos);
                System.out.print("ID a eliminar: "); long id=sc.nextLong(); sc.nextLine();
                Equipo borrar=null; for(Equipo e:s.equipos) if(e.getId()==id) borrar=e;
                if(borrar!=null){ s.equipos.remove(borrar); for(Torneo t:s.torneos) t.removeEquipo(borrar);}
            } else if(op==10){
                System.out.println("Torneos: "+s.torneos);
                System.out.print("ID a eliminar: "); long id=sc.nextLong(); sc.nextLine();
                Torneo borrar=null; for(Torneo t:s.torneos) if(t.getId()==id) borrar=t;
                if(borrar!=null){ borrar.eliminarTodasPartidas(); s.torneos.remove(borrar);}
            } else if(op==11){
                s.imprimirEstado();
            }
        } while(op!=0);
        sc.close();
    }
}
