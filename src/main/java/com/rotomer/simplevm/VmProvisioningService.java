package com.rotomer.simplevm;

import com.google.protobuf.InvalidProtocolBufferException;
import com.rotomer.simplevm.messages.ProvisionVmCommand;
import com.rotomer.simplevm.messages.Vm;

import java.util.UUID;

class VmProvisioningService {

    private static String nextId() {
        return UUID.randomUUID().toString();
    }

    void provisionVm(final byte[] serializedFormat) throws InvalidProtocolBufferException {
        final ProvisionVmCommand provisionVmCommand = ProvisionVmCommand.parseFrom(serializedFormat);

        final String id = nextId();
        final Vm vm = Vm.newBuilder()
                .setId(id)
                .setVmSpec(provisionVmCommand.getVmSpec())
                .setRegion(provisionVmCommand.getRegion())
                .build();

        System.out.println("Provisioned vm:\n" + vm);
    }
}

