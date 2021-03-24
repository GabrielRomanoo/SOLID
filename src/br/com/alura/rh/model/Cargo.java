package br.com.alura.rh.model;

public enum Cargo {
	/* 
	 * Um Enum não precisa necessariamente ter apenas constantes, ele pode ter metodos tambem
	 */

	ASSISTENTE { //constante
		@Override
		public Cargo getProximoCargo() { //metodo da constante
			return ANALISTA;
		}
	},
	ANALISTA {
		@Override
		public Cargo getProximoCargo() {
			return ESPECIALISTA;
		}
	},
	ESPECIALISTA {
		@Override
		public Cargo getProximoCargo() {
			return GERENTE;
		}
	},
	GERENTE {
		@Override
		public Cargo getProximoCargo() {
			return GERENTE;
		}
	};

	public abstract Cargo getProximoCargo(); //por ser um metodo abstrato, as constantes precisam implementar este metodo

}
