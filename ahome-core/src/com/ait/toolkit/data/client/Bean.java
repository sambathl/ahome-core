/**
 Copyright (c) 2014 Ahomé Innovation Technologies. All rights reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.ait.toolkit.data.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ait.toolkit.core.client.FastMap;

/**
 * A <code>BaseModel</code> instance that wraps a bean. BeanModels cannot be
 * instantiated directly, rather, they are returned by {@link BeanFactory}.
 * 
 * <p/>
 * Nested beans are supported when creating Bean instances with limited support
 * for nested lists of beans. Any child lists must be defined with
 * java.util.List and must be paramertized with a BeanTag class or subclass.
 * 
 * <p/>
 * When working with bean models, avoid setting beans as values, rather, set the
 * wrapping bean model instance.
 * 
 * @see BeanFactory
 */
public class Bean extends BaseModel {

	transient protected Object bean;
	protected Map<String, Bean> nestedModels = new FastMap<Bean>();
	protected List<String> beanProperties = new ArrayList<String>();

	protected Bean() {

	}

	/**
	 * Returns the bean.
	 * 
	 * @return the bean
	 */
	@SuppressWarnings("unchecked")
	public <X> X getBean() {
		return (X) bean;
	}

	@Override
	public String toString() {
		return ((Object) getBean()).toString();
	}

	protected Object processValue(Object value) {
		return value;
	}

	/**
	 * Sets the bean.
	 * 
	 * @param bean
	 *            the bean
	 */
	protected void setBean(Object bean) {
		this.bean = bean;
	}

}
