package com.element.in.config;

import java.util.List;

public class ISModuleConfiguration {
			private String name;
			private String code;
			private double risk;
			private double min;
			private double max;
			private List<Integer> packages;
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public double getRisk() {
				return risk;
			}
			public void setRisk(double risk) {
				this.risk = risk;
			}
			public List<Integer> getPackages() {
				return packages;
			}
			public void setPackages(List<Integer> packages) {
				this.packages = packages;
			}
			public double getMin() {
				return min;
			}
			public void setMin(double min) {
				this.min = min;
			}
			public double getMax() {
				return max;
			}
			public void setMax(double max) {
				this.max = max;
			}
			public String getCode() {
				return code;
			}
			public void setCode(String code) {
				this.code = code;
			}
}
