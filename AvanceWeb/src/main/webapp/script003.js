// Clase Medico
class Medico {
  constructor(codigo, nombre, apellido, nacimiento) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.apellido = apellido;
    this.nacimiento = nacimiento;
  }

  getCodigo() {
    return this.codigo;
  }

  getNombre() {
    return this.nombre;
  }

  getApellido() {
    return this.apellido;
  }

  getNacimiento() {
    return this.nacimiento;
  }
}

// Clase Nodo
class Nodo {
  constructor(dato) {
    this.dato = dato;
    this.siguiente = null;
  }

  setSiguiente(nodo) {
    this.siguiente = nodo;
  }

  getSiguiente() {
    return this.siguiente;
  }

  getDato() {
    return this.dato;
  }
}

// Clase listaCircular
class listaCircular {
  constructor() {
    this.cabeza = null;
  }

  agregarFinal(medico) {
    const nuevoNodo = new Nodo(medico);
    if (this.cabeza === null) {
      this.cabeza = nuevoNodo;
      nuevoNodo.setSiguiente(this.cabeza);
    } else {
      let actual = this.cabeza;
      while (actual.getSiguiente() !== this.cabeza) {
        actual = actual.getSiguiente();
      }
      actual.setSiguiente(nuevoNodo);
      nuevoNodo.setSiguiente(this.cabeza);
    }
  }

  eliminarNodo(codigoMedi) {
    if (this.cabeza === null) {
      alert("Tu wbd esta vacia, que vas a eliminar bab...?.");
      return;
    }
    let actual = this.cabeza;
    let anterior = null;

    do {
      const dato = actual.getDato();
      if (dato instanceof Medico && dato.getCodigo() == codigoMedi) {
        if (actual === this.cabeza && actual.getSiguiente() === this.cabeza) {
          this.cabeza = null;
        } else {
          if (actual === this.cabeza) {
            anterior = this.cabeza;
            while (anterior.getSiguiente() !== this.cabeza) {
              anterior = anterior.getSiguiente();
            }
            this.cabeza = this.cabeza.getSiguiente();
            anterior.setSiguiente(this.cabeza);
          } else {
            anterior.setSiguiente(actual.getSiguiente());
          }
        }
        alert("Nodo con código: " + codigoMedi + " ha sido eliminado correctamente.");
        return;
      }
      anterior = actual;
      actual = actual.getSiguiente();
    } while (actual !== this.cabeza);

    alert("Nodo con codigo: " + codigoMedi + " no ha sido encontrado.");
  }

  mostrarCircular() {
    if (this.cabeza === null) {
      alert("No hay nada en la lista web...");
      return;
    }
    let actual = this.cabeza;
    let resultado = "Lista Circular - (Medico)\n";
    do {
      const a = actual.getDato();
      const fecha = new Date(a.getNacimiento()).toLocaleDateString("es-PE");
      resultado += `${a.getCodigo()} - ${a.getNombre()} - ${a.getApellido()} - ${fecha}\n`;
      actual = actual.getSiguiente();
    } while (actual !== this.cabeza);
    resultado += "De nuevo al comienzo en este punto :3";
    document.getElementById("salida").innerText = resultado;
  }
}

// Instancia global
const lista = new listaCircular();

// Funciones para los botones
function agregarMedico() {
  const codigo = document.getElementById("txtCodigo").value;
  const nombre = document.getElementById("txtNombre").value;
  const apellido = document.getElementById("txtApellido").value;
  const nacimiento = document.getElementById("txtFecNac").value;

  if (!codigo || !nombre || !apellido || !nacimiento) {
    alert("Completa todo bb, no dejes campos vacíos.");
    return;
  }

  const medico = new Medico(parseInt(codigo), nombre, apellido, nacimiento);
  lista.agregarFinal(medico);
  alert("Médico agregado con éxito");
}

function eliminarMedico() {
  const codigo = prompt("Ingresa el código del médico a eliminar:");
  if (!codigo) {
    alert("No ingresaste ningún código bro.");
    return;
  }
  lista.eliminarNodo(parseInt(codigo));
}

function mostrarMedicos() {
  lista.mostrarCircular();
}