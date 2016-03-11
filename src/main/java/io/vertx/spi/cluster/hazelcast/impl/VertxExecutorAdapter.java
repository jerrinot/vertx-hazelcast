package io.vertx.spi.cluster.hazelcast.impl;

import io.vertx.core.Vertx;

import java.util.concurrent.Executor;

final class VertxExecutorAdapter implements Executor {

    private final Vertx vertx;

    VertxExecutorAdapter(Vertx vertx) {
        this.vertx = vertx;
    }

    @Override
    public void execute(Runnable command) {
        vertx.runOnContext(aVoid -> command.run());
    }
}
