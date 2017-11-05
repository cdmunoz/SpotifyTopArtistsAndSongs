package co.medellinandroid.spotifyartists.utils

/**
 * Copyright 2015 Erik Jhordan Rey.
 *
 * Taken from Erik's github repository in order to apply a blur to an image using Picasso's transformation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context
import android.graphics.Bitmap
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import com.squareup.picasso.Transformation

class BlurEffect(protected val context: Context, radius: Int) : Transformation {
  private val blurRadius: Int

  companion object {
    private val UP_LIMIT = 25
    private val LOW_LIMIT = 1
  }

  init {
    when {
      radius < LOW_LIMIT -> this.blurRadius = LOW_LIMIT
      radius > UP_LIMIT -> this.blurRadius = UP_LIMIT
      else -> this.blurRadius = radius
    }
  }

  override fun transform(source: Bitmap): Bitmap {

    val blurredBitmap: Bitmap = Bitmap.createBitmap(source)

    val renderScript = RenderScript.create(context)

    val input = Allocation.createFromBitmap(renderScript, source,
        Allocation.MipmapControl.MIPMAP_FULL,
        Allocation.USAGE_SCRIPT)

    val output = Allocation.createTyped(renderScript, input.type)

    val script = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript))

    script.setInput(input)
    script.setRadius(blurRadius.toFloat())

    script.forEach(output)
    output.copyTo(blurredBitmap)

    return blurredBitmap
  }

  override fun key(): String = "blurred"
}
