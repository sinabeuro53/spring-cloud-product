package com.example.springcloudproduct.core.product.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPrdNoEmbed is a Querydsl query type for PrdNoEmbed
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QPrdNoEmbed extends BeanPath<PrdNoEmbed> {

    private static final long serialVersionUID = -1065709368L;

    public static final QPrdNoEmbed prdNoEmbed = new QPrdNoEmbed("prdNoEmbed");

    public final NumberPath<Long> prdNo = createNumber("prdNo", Long.class);

    public final NumberPath<Long> prdPrcNo = createNumber("prdPrcNo", Long.class);

    public QPrdNoEmbed(String variable) {
        super(PrdNoEmbed.class, forVariable(variable));
    }

    public QPrdNoEmbed(Path<? extends PrdNoEmbed> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPrdNoEmbed(PathMetadata metadata) {
        super(PrdNoEmbed.class, metadata);
    }

}

