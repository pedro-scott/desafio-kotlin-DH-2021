package br.com.digitalhouse.desafioKotlin.modelo

abstract class Professor(private val registrarCodigoProfessor: Boolean) {
    abstract val nomeProfessor: String
    abstract val sobrenomeProfessor: String
    protected var tempoCasa = 0
    abstract val tipoProfessor: String

    //Companion responsável por controlar os códigos fornecidos aos professores, armazenando os ativos e excluídos.
    companion object {
        private var codigoProfessorDisponivel = 1
        private val codigosProfessoresAtivos = mutableListOf<Int>()
        private val codigosProfessoresExcluidos = mutableListOf<Int>()

//        fun imprimirCodigosProfessoresAtivos() {
//            print("Códigos Professores Ativos: ")
//            codigosProfessoresAtivos.forEach { print("$it ") }
//        }

//        fun imprimirCodigosProfessoresExcluidos() {
//            print("Códigos Professores Excluídos: ")
//            codigosProfessoresExcluidos.forEach { print("$it ") }
//        }
    }

    // Remove o código informado da lista codigosProfessoresAtivos e add na lista codigosProfessoresExcluidos.
    fun removerDeCodigosProfessoresAtivos() : Boolean =
        if (codigosProfessoresAtivos.contains(element = this.codigoProfessor) && registrarCodigoProfessor) {
            codigosProfessoresAtivos.remove(element = this.codigoProfessor)
            codigosProfessoresExcluidos.add(element = this.codigoProfessor)
            true
        } else false

    var codigoProfessor = codigoProfessorDisponivel
        private set

    init {
        // Verificação para inclusão na lista do companion.
        // Por padrão o código de um objeto Professor sempre será adicionado a lista do companion.
        if (registrarCodigoProfessor) {
            codigosProfessoresAtivos.add(codigoProfessorDisponivel)
            codigoProfessorDisponivel++
        }
    }

    //Sobrescreve o equals da classe atual.
    override fun equals(other: Any?): Boolean =
        when (other) {
            is Professor -> {
                when {
                    this.tipoProfessor != other.tipoProfessor -> false
                    this.nomeProfessor != other.nomeProfessor -> false
                    this.sobrenomeProfessor != other.sobrenomeProfessor -> false
                    this.codigoProfessor != other.codigoProfessor -> false
                    this.tempoCasa != other.tempoCasa -> false
                    else -> true
                }
            }
            else -> false
        }

    //Sobrescreve o hashCode da classe atual.
    override fun hashCode(): Int {
        var result = nomeProfessor.hashCode()

        result = 31 * result + sobrenomeProfessor.hashCode()
        result = 31 * result + tempoCasa
        result = 31 * result + tipoProfessor.hashCode()
        result = 31 * result + codigoProfessor

        return result
    }
}

//*********************************************************************************************************************

class ProfessorTitular(
    override val nomeProfessor: String,
    override val sobrenomeProfessor: String,
    val especialidade: String,
    registrarCodigoTitular: Boolean = true
) : Professor(registrarCodigoTitular) {
    override val tipoProfessor = "Titular"

    //Sobrescreve o toString da classe atual.
    override fun toString(): String =
        """
            |Professor $tipoProfessor - ${codigoProfessor.toString().padStart(length = 5, padChar = '0')}
            |   Nome: $nomeProfessor
            |   Sobrenome: $sobrenomeProfessor
            |   Tempo de Casa: $tempoCasa meses
            |   Especialidade: $especialidade
            |----------------------------------------
        """.trimMargin()

    //Formata uma string da classe atual para a classe Curso.
    val toStringCurso: String get() =
        """
            |   Professor $tipoProfessor - ${codigoProfessor.toString().padStart(length = 5, padChar = '0')}
            |       Nome: $nomeProfessor
            |       Sobrenome: $sobrenomeProfessor
            |       Tempo de Casa: $tempoCasa meses
            |       Especialidade: $especialidade
        """.trimMargin()

    //Formata uma string da classe atual para a classe Matricula.
    val toStringMatricula: String get() =
        """
            |           Professor $tipoProfessor - ${codigoProfessor.toString().padStart(length = 5, padChar = '0')}
            |               Nome: $nomeProfessor
            |               Sobrenome: $sobrenomeProfessor
            |               Tempo de Casa: $tempoCasa meses
            |               Especialidade: $especialidade
        """.trimMargin()
}

//*********************************************************************************************************************

class ProfessorAdjunto(
    override val nomeProfessor: String,
    override val sobrenomeProfessor: String,
    val horasMonitoria: Int,
    registrarCodigoAdjunto: Boolean = true
) : Professor(registrarCodigoAdjunto) {
    override val tipoProfessor = "Adjunto"

    //Sobrescreve o toString da classe atual.
    override fun toString(): String =
        """
            |Professor $tipoProfessor - ${codigoProfessor.toString().padStart(length = 5, padChar = '0')}
            |   Nome: $nomeProfessor
            |   Sobrenome: $sobrenomeProfessor
            |   Tempo de Casa: $tempoCasa meses
            |   Horas de Monitoria: $horasMonitoria horas
            |----------------------------------------
        """.trimMargin()

    //Formata uma string da classe atual para ser usada na classe Curso.
    val toStringCurso: String get() =
        """
            |   Professor $tipoProfessor - ${codigoProfessor.toString().padStart(length = 5, padChar = '0')}
            |       Nome: $nomeProfessor
            |       Sobrenome: $sobrenomeProfessor
            |       Tempo de Casa: $tempoCasa meses
            |       Horas de Monitoria: $horasMonitoria
        """.trimMargin()

    //Formata uma string da classe atual para ser usada na classe Matricula.
    val toStringMatricula: String get() =
        """
            |           Professor $tipoProfessor - ${codigoProfessor.toString().padStart(length = 5, padChar = '0')}
            |               Nome: $nomeProfessor
            |               Sobrenome: $sobrenomeProfessor
            |               Tempo de Casa: $tempoCasa meses
            |               Horas de Monitoria: $horasMonitoria
        """.trimMargin()
}