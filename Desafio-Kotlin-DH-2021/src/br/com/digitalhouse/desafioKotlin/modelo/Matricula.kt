package br.com.digitalhouse.desafioKotlin.modelo

import java.text.SimpleDateFormat
import java.util.Date

class Matricula(
    val aluno: Aluno,
    registrarCodigoMatricula: Boolean = true
) {
    private val cursosMatriculados = mutableListOf<Curso>()
    val data = formataData

    //Formata a data local e retorna a string dela de acordo com a formatação.
    private val formataData: String get() {
        val formatterDate = SimpleDateFormat("dd 'de' MMMM 'de' yyyy 'às' HH:mm:ss")

        return formatterDate.format(Date())
    }

    //Companion responsável por controlar os códigos fornecidos as matriculas, armazenando os ativos e excluídos.
    companion object {
        private var codigoMatriculaDisponivel = 1
        private val codigosMatriculasAtivas = mutableListOf<Int>()
        private val codigosMatriculasExcluidas = mutableListOf<Int>()

//        fun imprimirCodigosMatriculasAtivas() = codigosMatriculasAtivas.forEach { print("$it ") }
//        fun imprimirCodigosMatriculasExcluidas() = codigosMatriculasExcluidas.forEach { print("$it ") }

        // Remove o código informado da lista codigosMatriculasAtivas e add na lista codigosMatriculasExcluidas.
        fun removerDeCodigosMatriculasAtivas(codigo: Int) : Boolean =
            if (codigosMatriculasAtivas.contains(element = codigo)) {
                codigosMatriculasAtivas.remove(element = codigo)
                codigosMatriculasExcluidas.add(element = codigo)
                true
            } else false
    }

    var codigoMatricula = codigoMatriculaDisponivel
        private set

    init {
        // Verificação para inclusão na lista do companion.
        // Por padrão o código de um objeto Matricula sempre será adicionado a lista do companion.
        if (registrarCodigoMatricula) {
            codigosMatriculasAtivas.add(codigoMatriculaDisponivel)
            codigoMatriculaDisponivel++
        }
    }

    //Sobrescreve o equals da classe atual.
    override fun equals(other: Any?): Boolean =
        when (other) {
            is Matricula -> {
                when {
                    this.aluno != other.aluno -> false
                    this.cursosMatriculados != other.cursosMatriculados -> false
                    this.codigoMatricula != other.codigoMatricula -> false
                    this.data != other.data -> false
                    else -> true
                }
            }
            else -> false
        }

    //Sobrescreve o hashCode da classe atual.
    override fun hashCode(): Int {
        var result = aluno.hashCode()

        result = 31 * result + cursosMatriculados.hashCode()
        result = 31 * result + data.hashCode()
        result = 31 * result + codigoMatricula

        return result
    }

    //Constroi uma string que representa os cursos matriculados e será usada na toString da classe atual.
    private val toStringCursosMatriculados: String get() {
        if (cursosMatriculados.isEmpty()) return "       Não existem cursos matriculados!"

        val string = StringBuilder()

        cursosMatriculados.forEach {
            string.append(it.toStringMatricula)
            if (it != cursosMatriculados.last()) string.append("\n\n")
        }

        return string.toString()
    }

    //Sobrescreve o toString da classe atual.
    override fun toString(): String =
        """
            |Matrícula - ${codigoMatricula.toString().padStart(length = 5, padChar = '0')}
            |   Data: $data
            |
            |${aluno.toStringMatricula}
            |            
            |   Cursos Matriculados:
            |$toStringCursosMatriculados
            |----------------------------------------
        """.trimMargin()

    //Adiciona um curso na lista cursosMatriculados da classe atual.
    fun addCurso(umCurso: Curso) { cursosMatriculados.add(element = umCurso) }

    //Remove um curso na lista cursosMatriculados da classe atual.
    fun removerCurso(umCurso: Curso) { cursosMatriculados.remove(element = umCurso) }

    //Verifica se a classe atual possui o curso informado.
    fun verificarCurso(umCurso: Curso): Boolean =
        when {
            cursosMatriculados.find { it == umCurso } != null -> true
            else -> false
        }

    //Verifica se a classe atual não possui nenhum curso.
    val nenhumCursoMatriculado: Boolean get() = cursosMatriculados.isEmpty()
}