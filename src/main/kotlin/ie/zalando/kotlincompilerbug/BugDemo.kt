package ie.zalando.kotlincompilerbug

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SomeRepo : JpaRepository<String, Long>

class ConcreteImplWithOverrides(val springGeneratedSomeRepoImpl: SomeRepo) : SomeRepo by springGeneratedSomeRepoImpl {

    // This is allowed by the compiler
    override fun <S : String?> save(entity: S): S {
        TODO("Not yet implemented")
    }

    // This fails to compile
    // Conflicting overloads: public open fun findById(id: Long): Optional<String> defined in
    // ie.zalando.kotlincompilerbug.ConcreteImplWithOverrides, public open fun findById(id: Long): Optional<String!>
    // defined in ie.zalando.kotlincompilerbug.ConcreteImplWithOverrides
    override fun findById(id: Long): Optional<String> {
        TODO("Not yet implemented")
    }
}