package com.emc.ecs.management.sdk;

import com.emc.ecs.management.sdk.model.BucketTagsParamAdd;
import com.emc.ecs.management.sdk.model.BucketTagsParamDelete;
import com.emc.ecs.management.sdk.model.BucketTagsParamUpdate;
import com.emc.ecs.servicebroker.exception.EcsManagementClientException;

import javax.ws.rs.core.UriBuilder;

import java.util.List;
import java.util.Map;

import static com.emc.ecs.management.sdk.Constants.*;

public class BucketTagsAction {

    private BucketTagsAction(){}

    public static void create(Connection connection, String id, String namespace, List<Map<String, String> > tags)
            throws EcsManagementClientException {
        UriBuilder uri = connection.getUriBuilder().segment(OBJECT, BUCKET, id, TAGS);
        connection.handleRemoteCall(POST, uri, new BucketTagsParamAdd(namespace, tags));
    }

    public static void update(Connection connection, String id, String namespace, List<Map<String, String> > tags) {
        UriBuilder uri = connection.getUriBuilder().segment(OBJECT, BUCKET, id, TAGS);
        connection.handleRemoteCall(PUT, uri, new BucketTagsParamUpdate(namespace, tags));
    }
    public static void delete(Connection connection, String id, String namespace, List<Map<String, String> > tags) {
        UriBuilder uri = connection.getUriBuilder().segment(OBJECT, BUCKET, id, TAGS);
        connection.handleRemoteCall(DELETE, uri, new BucketTagsParamDelete(namespace, tags));
    }
}
