// Clase Persona
class Persona {
  constructor(dni, nombre, apellido, nacimiento) {
    this.dni = dni;
    this.nombre = nombre;
    this.apellido = apellido;
    this.nacimiento = nacimiento;
  }
}

// Nodo de la lista
class Nodo {
  constructor(dato) {
    this.dato = dato;
    this.siguiente = null;
  }
}

// Clase Lista Enlazada
class ListaEnlazada {
  constructor() {
    this.cabeza = null;
  }

  insertarFinal(persona) {
    const nuevoNodo = new Nodo(persona);
    if (this.cabeza === null) {
      this.cabeza = nuevoNodo;
    } else {
      let actual = this.cabeza;
      while (actual.siguiente !== null) {
        actual = actual.siguiente;
      }
      actual.siguiente = nuevoNodo;
    }
    alert("Persona insertada al final.");
  }

  eliminarFinal() {
    if (this.cabeza === null) {
      alert("La lista está vacía, no hay nada que eliminar OE");
    } else if (this.cabeza.siguiente === null) {
      this.cabeza = null;
      alert("La lista se ha vaciado como el amor de ella MIGAJERO");
    } else {
      let actual = this.cabeza;
      while (actual.siguiente.siguiente !== null) {
        actual = actual.siguiente;
      }
      actual.siguiente = null;
      alert("Se eliminó el último elemento UwU");
    }
  }

  mostrarLista() {
    if (this.cabeza === null) {
      alert("La lista está vacía, no hay nada que mostrar BAB...");
      return;
    }
    let actual = this.cabeza;
    let mensaje = "Lista Enlazada - Persona\n";
    while (actual !== null) {
      const p = actual.dato;
      const fecha = new Date(p.nacimiento).toLocaleDateString("es-PE");
      mensaje += `${p.dni} - ${p.nombre} - ${p.apellido} - ${fecha}\n`;
      actual = actual.siguiente;
    }
    document.getElementById("salida").innerText = mensaje;
  }
}

// Instancia global
const lista = new ListaEnlazada();

// Funciones para botones
function insertarFinal() {
  const dni = document.getElementById("txtCodigo").value;
  const nombre = document.getElementById("txtNombre").value;
  const apellido = document.getElementById("txtApellido").value;
  const nacimiento = document.getElementById("txtFecNac").value;

  if (!dni || !nombre || !apellido || !nacimiento) {
    alert("Completa todos los campos, causa.");
    return;
  }

  const persona = new Persona(dni, nombre, apellido, nacimiento);
  lista.insertarFinal(persona);
}

function eliminarFinal() {
  lista.eliminarFinal();
}

function mostrarLista() {
  lista.mostrarLista();
}