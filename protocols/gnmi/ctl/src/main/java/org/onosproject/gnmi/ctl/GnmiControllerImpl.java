/*
 * Copyright 2018-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.onosproject.gnmi.ctl;

import io.grpc.ManagedChannel;
import org.onosproject.gnmi.api.GnmiClient;
import org.onosproject.gnmi.api.GnmiClientKey;
import org.onosproject.gnmi.api.GnmiController;
import org.onosproject.gnmi.api.GnmiEvent;
import org.onosproject.gnmi.api.GnmiEventListener;
import org.onosproject.grpc.ctl.AbstractGrpcClientController;
import org.osgi.service.component.annotations.Component;

/**
 * Implementation of gNMI controller.
 */
@Component(immediate = true, service = GnmiController.class)
public class GnmiControllerImpl
        extends AbstractGrpcClientController
        <GnmiClientKey, GnmiClient, GnmiEvent, GnmiEventListener>
        implements GnmiController {

    public GnmiControllerImpl() {
        super(GnmiEvent.class);
    }

    @Override
    protected GnmiClient createClientInstance(
            GnmiClientKey clientKey, ManagedChannel channel) {
        return new GnmiClientImpl(clientKey, channel, this);
    }
}
