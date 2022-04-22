package com.talentyco.chapter02;

import com.talentyco.chapter02.framework.adapters.input.stdin.RouterViewCLIAdapter;


public class App {

	public static void main(String ... args) {
		var cli = new RouterViewCLIAdapter();
		var type = "CORE";

		System.out.println(cli.obtainRelatedRouters(type));
		System.out.println();
	}
}
