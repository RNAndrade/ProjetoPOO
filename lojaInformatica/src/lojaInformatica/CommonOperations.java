package lojaInformatica;

import static com.ninja_squad.dbsetup.Operations.*;
import com.ninja_squad.dbsetup.operation.Operation;

public class CommonOperations {
	public static final Operation DELETE_ALL =
	        deleteAllFrom("cliente");

	public static final Operation INSERT_REFERENCE_DATA =
	        sequenceOf(
	            insertInto("cliente")
	                .columns("clieCPF", "clieNome","clieEnd", "clieTel", "clieEmail")
	                .values("12345678901", "Deivison", "Rua Deivison", "90900098", "deivison@gmail.com")
	                .values("12345678902", "Saulo", "Rua Saulo", "90900097", "saulo@gmail.com")
	                .values("12345678903", "João", "Rua João", "90900096", "joao@gmail.com")
	                .values("12345678904", "Pedro", "Rua Pedro", "90900095", "pedro@gmail.com")
	                .build());
	
}
