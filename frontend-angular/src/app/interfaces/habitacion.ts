export interface Habitacion {

  numero: string,
  cliente: {
    id: number,
    nombre: string,
    apellidos: string,
    numPersonas: number
  };

}
