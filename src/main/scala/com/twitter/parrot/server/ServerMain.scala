/*
Copyright 2012 Twitter, Inc.

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
package com.twitter.parrot.server

import com.twitter.logging.Logger
import com.twitter.ostrich.admin.{RuntimeEnvironment, Service}

object ServerMain {
  val log = Logger.get(getClass.getName)

  def main(args: Array[String]) {
    try {
      val runtime = RuntimeEnvironment(this, args)
      val server: Service = runtime.loadRuntimeConfig()
      server.start()
    } catch {
      case e: Exception =>
        e.printStackTrace()
        log.error(e, "Unexpected exception: %s", e.getMessage)
        System.exit(0)
    }
  }
}
