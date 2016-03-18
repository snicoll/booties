/**
 * Copyright (C) 2015 Zalando SE (http://tech.zalando.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zalando.stups.mcb;

import java.lang.reflect.Proxy;

public class MCBProxy {

    public static <T> T proxy(T target, Class<T> iface){
        return proxy(target, iface, McbInvocationHandler.NOT_SET);
    }

    @SuppressWarnings("unchecked")
    public static <T> T proxy(T target, Class<T> iface, Object def) {
        return (T) Proxy.newProxyInstance(iface.getClassLoader(), new Class[] { iface },
                new McbInvocationHandler(new MCB(), target, def));
    }

}