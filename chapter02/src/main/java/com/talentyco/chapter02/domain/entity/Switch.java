package com.talentyco.chapter02.domain.entity;

import com.talentyco.chapter02.domain.vo.IP;
import com.talentyco.chapter02.domain.vo.Network;
import com.talentyco.chapter02.domain.vo.SwitchId;
import com.talentyco.chapter02.domain.vo.SwitchType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Switch {

    private SwitchType switchType;
    private SwitchId switchId;
    private List<Network> networks;
    private IP address;

    public Switch(SwitchType switchType, SwitchId switchId, List<Network> networks, IP address) {
        this.switchType = switchType;
        this.switchId = switchId;
        this.networks = networks;
        this.address = address;
    }

    public Switch addNetwork(Network network) {
        var networks = new ArrayList<>(Arrays.asList(network));
        networks.add(network);
        return new Switch(this.switchType, this.switchId, networks, this.address);
    }

    public  List<Network> getNetwork() {
        return networks;
    }
}
