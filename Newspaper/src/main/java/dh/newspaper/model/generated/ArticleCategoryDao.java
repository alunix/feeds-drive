package dh.newspaper.model.generated;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import dh.newspaper.model.generated.ArticleCategory;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table ARTICLE_CATEGORY.
*/
public class ArticleCategoryDao extends AbstractDao<ArticleCategory, Long> {

    public static final String TABLENAME = "ARTICLE_CATEGORY";

    /**
     * Properties of entity ArticleCategory.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property CategoryId = new Property(1, Long.class, "categoryId", false, "CATEGORY_ID");
        public final static Property ArticleId = new Property(2, long.class, "articleId", false, "ARTICLE_ID");
    };

    private Query<ArticleCategory> article_ArticleCategoryListQuery;

    public ArticleCategoryDao(DaoConfig config) {
        super(config);
    }
    
    public ArticleCategoryDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'ARTICLE_CATEGORY' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'CATEGORY_ID' INTEGER," + // 1: categoryId
                "'ARTICLE_ID' INTEGER NOT NULL );"); // 2: articleId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'ARTICLE_CATEGORY'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ArticleCategory entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long categoryId = entity.getCategoryId();
        if (categoryId != null) {
            stmt.bindLong(2, categoryId);
        }
        stmt.bindLong(3, entity.getArticleId());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ArticleCategory readEntity(Cursor cursor, int offset) {
        ArticleCategory entity = new ArticleCategory( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // categoryId
            cursor.getLong(offset + 2) // articleId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ArticleCategory entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCategoryId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setArticleId(cursor.getLong(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ArticleCategory entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ArticleCategory entity) {
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
    
    /** Internal query to resolve the "articleCategoryList" to-many relationship of Article. */
    public List<ArticleCategory> _queryArticle_ArticleCategoryList(long articleId) {
        synchronized (this) {
            if (article_ArticleCategoryListQuery == null) {
                QueryBuilder<ArticleCategory> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ArticleId.eq(null));
                article_ArticleCategoryListQuery = queryBuilder.build();
            }
        }
        Query<ArticleCategory> query = article_ArticleCategoryListQuery.forCurrentThread();
        query.setParameter(0, articleId);
        return query.list();
    }

}