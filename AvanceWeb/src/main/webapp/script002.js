// Clase Alumno
class Alumno {
  constructor(codigo, nombre, nota, nacimiento) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.nota = nota;
    this.nacimiento = nacimiento;
  }
}

// Clase Nodo
class Nodo {
  constructor(dato) {
    this.dato = dato;
    this.siguiente = null;
    this.anterior = null;
  }

  setSiguiente(nodo) {
    this.siguiente = nodo;
  }

  getSiguiente() {
    return this.siguiente;
  }

  setAnterior(nodo) {
    this.anterior = nodo;
  }

  getAnterior() {
    return this.anterior;
  }

  getDato() {
    return this.dato;
  }
}

// Clase listaDobleEnlazada
class listaDobleEnlazada {
  constructor() {
    this.cabeza = null;
  }

  agregar(alumno) {
    const nuevonodo = new Nodo(alumno);
    if (this.cabeza === null) {
      this.cabeza = nuevonodo;
    } else {
      let actual = this.cabeza;
      while (actual.getSiguiente() !== null) {
        actual = actual.getSiguiente();
      }
      actual.setSiguiente(nuevonodo);
      nuevonodo.setAnterior(actual);
    }
  }

  mostrar() {
    if (this.cabeza === null) {
      alert("que vas a mostrar ps, si no hay nada");
      return;
    }
    let actual = this.cabeza;
    let resultado = "alumno: \n";
    resultado += "codigo - nombre - nota - nacimiento\n";
    while (actual !== null) {
      const a = actual.getDato();
      const fecha = new Date(a.nacimiento).toLocaleDateString("es-PE");
      resultado += `${a.codigo} - ${a.nombre} - ${a.nota} - ${fecha}\n`;
      actual = actual.getSiguiente();
    }
    document.getElementById("salida").innerText = resultado;
  }

  eliminarFinal() {
    if (this.cabeza === null) {
      alert("Esta vacio que mas quieres eliminar?");
    } else if (this.cabeza.getSiguiente() === null) {
      this.cabeza = null;
      alert("La lista se ha vaciado , ahora si no hay nada de nada");
    } else {
      let actual = this.cabeza;
      while (actual.getSiguiente() !== null) {
        actual = actual.getSiguiente();
      }
      actual.getAnterior().setSiguiente(null);
    }
  }
}

// Instancia global
const lista = new listaDobleEnlazada();

// Funciones para los botones
function agregarAlumno() {
  const codigo = document.getElementById("txtCodigo").value;
  const nombre = document.getElementById("txtNombre").value;
  const nota = document.getElementById("txtNota").value;
  const nacimiento = document.getElementById("txtFecNac").value;

  if (!codigo || !nombre || !nota || !nacimiento) {
    alert("Llena todos los campos pues, no seas flojo");
    return;
  }

  const alumno = new Alumno(codigo, nombre, parseFloat(nota), nacimiento);
  lista.agregar(alumno);
  alert("Alumno agregado con éxito");
}

function eliminarUltimo() {
  lista.eliminarFinal();
}

function imprimirLista() {
  lista.mostrar();
}