package yuda.freaky.popularmovies.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TRAILER".
*/
public class TrailerDao extends AbstractDao<Trailer, Long> {

    public static final String TABLENAME = "TRAILER";

    /**
     * Properties of entity Trailer.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Key = new Property(1, String.class, "key", false, "KEY");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Movie_id = new Property(3, long.class, "movie_id", false, "MOVIE_ID");
    };

    private Query<Trailer> movie_TrailersQuery;

    public TrailerDao(DaoConfig config) {
        super(config);
    }
    
    public TrailerDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TRAILER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"KEY\" TEXT," + // 1: key
                "\"NAME\" TEXT NOT NULL ," + // 2: name
                "\"MOVIE_ID\" INTEGER NOT NULL );"); // 3: movie_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TRAILER\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Trailer entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String key = entity.getKey();
        if (key != null) {
            stmt.bindString(2, key);
        }
        stmt.bindString(3, entity.getName());
        stmt.bindLong(4, entity.getMovie_id());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Trailer readEntity(Cursor cursor, int offset) {
        Trailer entity = new Trailer( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // key
            cursor.getString(offset + 2), // name
            cursor.getLong(offset + 3) // movie_id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Trailer entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setKey(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.getString(offset + 2));
        entity.setMovie_id(cursor.getLong(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Trailer entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Trailer entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "trailers" to-many relationship of Movie. */
    public List<Trailer> _queryMovie_Trailers(long movie_id) {
        synchronized (this) {
            if (movie_TrailersQuery == null) {
                QueryBuilder<Trailer> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Movie_id.eq(null));
                queryBuilder.orderRaw("T.'NAME' ASC");
                movie_TrailersQuery = queryBuilder.build();
            }
        }
        Query<Trailer> query = movie_TrailersQuery.forCurrentThread();
        query.setParameter(0, movie_id);
        return query.list();
    }

}
