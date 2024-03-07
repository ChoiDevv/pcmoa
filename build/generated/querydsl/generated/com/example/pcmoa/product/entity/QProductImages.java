package com.example.pcmoa.product.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductImages is a Querydsl query type for ProductImages
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductImages extends EntityPathBase<ProductImages> {

    private static final long serialVersionUID = -1342474994L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductImages productImages = new QProductImages("productImages");

    public final com.example.pcmoa.config.entity.QBaseEntity _super = new com.example.pcmoa.config.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath image = createString("image");

    public final QProducts products;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedDate = _super.updatedDate;

    public QProductImages(String variable) {
        this(ProductImages.class, forVariable(variable), INITS);
    }

    public QProductImages(Path<? extends ProductImages> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductImages(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductImages(PathMetadata metadata, PathInits inits) {
        this(ProductImages.class, metadata, inits);
    }

    public QProductImages(Class<? extends ProductImages> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.products = inits.isInitialized("products") ? new QProducts(forProperty("products")) : null;
    }

}

