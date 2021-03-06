/*
 * Copyright 2014 JBoss by Red Hat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.kie.services.helper;

import org.jbpm.services.task.commands.TaskCommand;
import org.kie.internal.command.Context;
import org.kie.internal.task.api.TaskContext;
import org.kie.internal.task.api.TaskPersistenceContext;

public class CleanUpCommand extends TaskCommand<Void>{
	private static final long serialVersionUID = 7161011443481073090L;

	@Override
	public Void execute(Context context) {
		TaskPersistenceContext persistenceContext = ((TaskContext) context).getPersistenceContext();
        persistenceContext.executeUpdateString("delete from  NodeInstanceLog nid");
        persistenceContext.executeUpdateString("delete from  ProcessInstanceLog pid");
        persistenceContext.executeUpdateString("delete from  VariableInstanceLog vsd");
        persistenceContext.executeUpdateString("delete from  AuditTaskImpl vsd");
		return null;
	}
}
