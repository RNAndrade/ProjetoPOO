package lojaInformatica;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.CompositeOperation;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.dbsetup.operation.SqlOperation;

import static com.ninja_squad.dbsetup.Operations.*;

public class ClienteTestes {

	private static DbSetupTracker dbSetupTracker = new DbSetupTracker();
	
    @Before
    public void prepare() throws Exception {
    	Operation operation =
                sequenceOf(
                    CommonOperations.DELETE_ALL,
                    CommonOperations.INSERT_REFERENCE_DATA);
    	DbSetup dbSetup = new DbSetup(new DriverManagerDestination("jdbc:mysql://localhost:3306/db_setup", "root", ""), operation);
        dbSetup.launch();
        dbSetupTracker.launchIfNecessary(dbSetup);
    }
    
    @Test
    public void testFindByName() {
    	dbSetupTracker.skipNextLaunch();
    	int count = jdbcTemplate.queryForObject("select count(*) from customer",
                Integer.class);
        assertEquals(4, count);
    }
	
}
